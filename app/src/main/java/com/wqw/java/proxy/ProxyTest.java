package com.wqw.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理测试
 *
 * @author WangQiuWei
 * @since 2018/7/3
 */
public class ProxyTest {
    public interface SellWine {
        void mainJiu();
    }
    public static class MaotaiJiu implements SellWine {
        @Override
        public void mainJiu() {
            System.out.println("我卖得是茅台酒。");

        }
    }

    public static class Wuliangye implements SellWine {
        @Override
        public void mainJiu() {
            // TODO Auto-generated method stub
            System.out.println("我卖得是五粮液。");

        }
    }

    public interface SellCigarette {
        void sell();
    }
    public static class Furongwang implements SellCigarette {

        @Override
        public void sell() {
            System.out.println("售卖的是正宗的芙蓉王，可以扫描条形码查证。");
        }
    }

    public static class GuitaiA implements InvocationHandler {

        private Object pingpai;

        public GuitaiA(Object pingpai) {
            this.pingpai = pingpai;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("销售开始  柜台是： "+this.getClass().getSimpleName());
            method.invoke(pingpai, args);
            System.out.println("销售结束");
            return null;
        }
    }

    public static class GuitaiB implements InvocationHandler {

        private Object pingpai;

        public GuitaiB(Object pingpai) {
            this.pingpai = pingpai;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            method.invoke(pingpai, args);
            method.invoke(pingpai, args);
            method.invoke(pingpai, args);
            return null;
        }
    }

    public static void main(String[] args) {
        MaotaiJiu maotaijiu = new MaotaiJiu();
        Wuliangye wu = new Wuliangye();
        Furongwang fu = new Furongwang();

        InvocationHandler jingxiao1 = new GuitaiA(maotaijiu);
        InvocationHandler jingxiao2 = new GuitaiB(wu);

        InvocationHandler jingxiao3 = new GuitaiA(fu);

        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(), jingxiao1);
        SellWine dynamicProxy1 = (SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(), jingxiao2);

        dynamicProxy.mainJiu();
        dynamicProxy1.mainJiu();

        SellCigarette dynamicProxy3 = (SellCigarette) Proxy.newProxyInstance(Furongwang.class.getClassLoader(),
                Furongwang.class.getInterfaces(), jingxiao3);
        dynamicProxy3.sell();

    }
}

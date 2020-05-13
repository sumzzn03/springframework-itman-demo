package com.liyong.ioccontainer.service;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className BookManager$$EnhancerBySpringCGLIB$$956bc0f6
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-13 23:02    
 *
 *
**/

//import com.liyong.ioccontainer.service.BookManager;
//import com.liyong.ioccontainer.service.IBookService;
//import java.lang.reflect.Method;
//import org.springframework.cglib.core.ReflectUtils;
//import org.springframework.cglib.core.Signature;
//import org.springframework.cglib.proxy.Callback;
//import org.springframework.cglib.proxy.Factory;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//import org.springframework.cglib.proxy.NoOp;
//
//public class BookManager$$EnhancerBySpringCGLIB$$956bc0f6
//        extends BookManager
//        implements Factory {
//    private boolean CGLIB$BOUND;
//    public static Object CGLIB$FACTORY_DATA;
//    private static final ThreadLocal CGLIB$THREAD_CALLBACKS;
//    private static final Callback[] CGLIB$STATIC_CALLBACKS;
//    private NoOp CGLIB$CALLBACK_0;
//    private MethodInterceptor CGLIB$CALLBACK_1;
//    private MethodInterceptor CGLIB$CALLBACK_2;
//    private static Object CGLIB$CALLBACK_FILTER;
//    private static final Method CGLIB$createBookService$0$Method;
//    private static final MethodProxy CGLIB$createBookService$0$Proxy;
//    private static final Object[] CGLIB$emptyArgs;
//
//    public BookManager$$EnhancerBySpringCGLIB$$956bc0f6() {
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6 bookManager$$EnhancerBySpringCGLIB$$956bc0f6 = this;
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$BIND_CALLBACKS(bookManager$$EnhancerBySpringCGLIB$$956bc0f6);
//    }
//
//    static {
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$STATICHOOK1();
//    }
//
//    /*
//     * Unable to fully structure code
//     * Enabled aggressive block sorting
//     * Lifted jumps to return sites
//     */
//    @Override
//    public Object newInstance(Class[] var1_1, Object[] var2_2, Callback[] var3_3) {
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$SET_THREAD_CALLBACKS(var3_3);
//        switch (var1_1.length) {
//            case 0: {
//                ** break;
//            }
//        }
//        throw new IllegalArgumentException("Constructor not found");
//        lbl6: // 1 sources:
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$SET_THREAD_CALLBACKS(null);
//        return new BookManager$$EnhancerBySpringCGLIB$$956bc0f6();
//    }
//
//    @Override
//    public Object newInstance(Callback[] arrcallback) {
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$SET_THREAD_CALLBACKS(arrcallback);
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$SET_THREAD_CALLBACKS(null);
//        return new BookManager$$EnhancerBySpringCGLIB$$956bc0f6();
//    }
//
//    @Override
//    public Object newInstance(Callback callback) {
//        throw new IllegalStateException("More than one callback object required");
//    }
//
//    public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
//        switch (((Object)signature).toString().hashCode()) {
//            case 775319437: {
//                String string;
//                if (!string.equals("createBookService()Lcom/liyong/ioccontainer/service/IBookService;")) break;
//                return CGLIB$createBookService$0$Proxy;
//            }
//            default: {
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void setCallbacks(Callback[] arrcallback) {
//        Callback[] arrcallback2 = arrcallback;
//        this.CGLIB$CALLBACK_0 = (NoOp)arrcallback2[0];
//        this.CGLIB$CALLBACK_1 = (MethodInterceptor)arrcallback2[1];
//        Callback[] arrcallback3 = arrcallback2;
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6 bookManager$$EnhancerBySpringCGLIB$$956bc0f6 = this;
//        this.CGLIB$CALLBACK_2 = (MethodInterceptor)arrcallback2[2];
//    }
//
//    @Override
//    public void setCallback(int n, Callback callback) {
//        switch (n) {
//            case 0: {
//                this.CGLIB$CALLBACK_0 = (NoOp)callback;
//                break;
//            }
//            case 1: {
//                this.CGLIB$CALLBACK_1 = (MethodInterceptor)callback;
//                break;
//            }
//            case 2: {
//                this.CGLIB$CALLBACK_2 = (MethodInterceptor)callback;
//                break;
//            }
//        }
//    }
//
//    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] arrcallback) {
//        CGLIB$STATIC_CALLBACKS = arrcallback;
//    }
//
//    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] arrcallback) {
//        CGLIB$THREAD_CALLBACKS.set(arrcallback);
//    }
//
//    @Override
//    public Callback getCallback(int n) {
//        Callback callback;
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$BIND_CALLBACKS(this);
//        switch (n) {
//            case 0: {
//                BookManager$$EnhancerBySpringCGLIB$$956bc0f6 bookManager$$EnhancerBySpringCGLIB$$956bc0f6;
//                callback = bookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$CALLBACK_0;
//                break;
//            }
//            case 1: {
//                BookManager$$EnhancerBySpringCGLIB$$956bc0f6 bookManager$$EnhancerBySpringCGLIB$$956bc0f6;
//                callback = bookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$CALLBACK_1;
//                break;
//            }
//            case 2: {
//                BookManager$$EnhancerBySpringCGLIB$$956bc0f6 bookManager$$EnhancerBySpringCGLIB$$956bc0f6;
//                callback = bookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$CALLBACK_2;
//                break;
//            }
//            default: {
//                callback = null;
//            }
//        }
//        return callback;
//    }
//
//    @Override
//    public Callback[] getCallbacks() {
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$BIND_CALLBACKS(this);
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6 bookManager$$EnhancerBySpringCGLIB$$956bc0f6 = this;
//        return new Callback[]{this.CGLIB$CALLBACK_0, this.CGLIB$CALLBACK_1, this.CGLIB$CALLBACK_2};
//    }
//
//    static void CGLIB$STATICHOOK1() {
//        CGLIB$THREAD_CALLBACKS = new ThreadLocal();
//        CGLIB$emptyArgs = new Object[0];
//        Class<?> class_ = Class.forName("com.liyong.ioccontainer.service.BookManager$$EnhancerBySpringCGLIB$$956bc0f6");
//        Class<?> class_2 = Class.forName("com.liyong.ioccontainer.service.BookManager");
//        CGLIB$createBookService$0$Method = ReflectUtils.findMethods(new String[]{"createBookService", "()Lcom/liyong/ioccontainer/service/IBookService;"}, class_2.getDeclaredMethods())[0];
//        CGLIB$createBookService$0$Proxy = MethodProxy.create(class_2, class_, "()Lcom/liyong/ioccontainer/service/IBookService;", "createBookService", "CGLIB$createBookService$0");
//    }
//
//    final IBookService CGLIB$createBookService$0() {
//        return super.createBookService();
//    }
//
//    private static final void CGLIB$BIND_CALLBACKS(Object object) {
//        BookManager$$EnhancerBySpringCGLIB$$956bc0f6 bookManager$$EnhancerBySpringCGLIB$$956bc0f6 = (BookManager$$EnhancerBySpringCGLIB$$956bc0f6)object;
//        if (!bookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$BOUND) {
//            bookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$BOUND = true;
//            Object object2 = CGLIB$THREAD_CALLBACKS.get();
//            if (object2 != null || (object2 = CGLIB$STATIC_CALLBACKS) != null) {
//                Callback[] arrcallback = (Callback[])object2;
//                BookManager$$EnhancerBySpringCGLIB$$956bc0f6 bookManager$$EnhancerBySpringCGLIB$$956bc0f62 = bookManager$$EnhancerBySpringCGLIB$$956bc0f6;
//                bookManager$$EnhancerBySpringCGLIB$$956bc0f62.CGLIB$CALLBACK_2 = (MethodInterceptor)arrcallback[2];
//                bookManager$$EnhancerBySpringCGLIB$$956bc0f62.CGLIB$CALLBACK_1 = (MethodInterceptor)arrcallback[1];
//                bookManager$$EnhancerBySpringCGLIB$$956bc0f62.CGLIB$CALLBACK_0 = (NoOp)arrcallback[0];
//            }
//        }
//    }
//
//    protected final IBookService createBookService() {
//        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_1;
//        if (methodInterceptor == null) {
//            BookManager$$EnhancerBySpringCGLIB$$956bc0f6.CGLIB$BIND_CALLBACKS(this);
//            methodInterceptor = this.CGLIB$CALLBACK_1;
//        }
//        if (methodInterceptor != null) {
//            return (IBookService)methodInterceptor.intercept(this, CGLIB$createBookService$0$Method, CGLIB$emptyArgs, CGLIB$createBookService$0$Proxy);
//        }
//        return super.createBookService();
//    }
//}


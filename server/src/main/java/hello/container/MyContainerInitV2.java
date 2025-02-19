package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@HandlesTypes(AppInit.class)
public class MyContainerInitV2 implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx)  {
        System.out.println("MyContainerInitV2.onStartUp");
        System.out.println("MyContainerInitV2 c = " + c);
        System.out.println("MyContainerInitV2 ctx = "+ ctx);
        
        //class hello.container.AppInitV1Servlet
        for (Class<?> aClass : c) {
            try {
                 AppInit appInit = (AppInit) aClass.getDeclaredConstructor().newInstance();
                appInit.onStartUp(ctx);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class Junit3TestRunner {

    // getMethods는 객체의 메서드를 조회하는데, 해당 클래스가 상속한 클래스의 메서드들도 모두 가져온다.
    // Junit3에서는 메서드 이름이 test로 시작하면서, TestCase라는 클래스를 상속해야 테스트를 실행해주는 규칙이 존재했다.!
    @Test
    void run() throws Exception {
        Class<Junit3Test> clazz = Junit3Test.class;

        Constructor<Junit3Test> constructor = clazz.getConstructor();
        Junit3Test junit3Test = constructor.newInstance();

        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            // 매개변수가 존재하는 경우도 있나?
            if(method.getName().toLowerCase().startsWith("test") && method.getParameterCount() == 0){
                method.invoke(junit3Test);
            }
        }
    }
}

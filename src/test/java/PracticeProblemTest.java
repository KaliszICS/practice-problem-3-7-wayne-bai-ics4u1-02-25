import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.lang.reflect.Method;

public class PracticeProblemTest {
  
@Test
@DisplayName("")
void SearchMazeMovesTest3() {
  Class<?> testClass = PracticeProblem.class;
  try {
    Class[] cArg = {String[][].class};
    Method method = testClass.getDeclaredMethod("searchMazeMoves", cArg);
    String[][] maze = {
      {"", "", "", "", ""},
      {"", "*", "", "", ""},
      {"", "*", "", "*", ""},
      {"S", "*", "", "", "F"},
    };
    assertEquals(10, (int)method.invoke(null, new Object[]{maze}));
  }
  catch (NoSuchMethodException e) {
    fail("Method does not exist");
  }
  catch (Exception e) {
    fail("Something weird happened");
  }
}

@Test
@DisplayName("")
void SearchMazeMovesTest2() {
  Class<?> testClass = PracticeProblem.class;
  try {
    Class[] cArg = {String[][].class};
    Method method = testClass.getDeclaredMethod("searchMazeMoves", cArg);
    String[][] maze = {
      {"", "", "", "", ""},
      {"", "", "", "", ""},
      {"", "", "*", "", ""},
      {"S", "*", "F", "", ""},
    };
    assertEquals(8, (int)method.invoke(null, new Object[]{maze}));
  }
  catch (NoSuchMethodException e) {
    fail("Method does not exist");
  }
  catch (Exception e) {
    fail("Something weird happened");
  }
}

@Test
@DisplayName("")
void SearchMazeMovesTest1() {
  Class<?> testClass = PracticeProblem.class;
  try {
    Class[] cArg = {String[][].class};
    Method method = testClass.getDeclaredMethod("searchMazeMoves", cArg);
    String[][] maze = {
      {"", "", "", ""},
      {"", "", "", ""},
      {"", "", "", ""},
      {"S", "*", "F", "*"},
    };
    assertEquals(8, (int)method.invoke(null, new Object[]{maze}));
  }
  catch (NoSuchMethodException e) {
    fail("Method does not exist");
  }
  catch (Exception e) {
    fail("Something weird happened");
  }
}

@Test
@DisplayName("")
void SearchMazeMovesTest4() {
  Class<?> testClass = PracticeProblem.class;
  try {
    Class[] cArg = {String[][].class};
    Method method = testClass.getDeclaredMethod("searchMazeMoves", cArg);
    String[][] maze = {
      {"", "*", ""},
      {"S", "*", "F"},
    };
    assertEquals(-1, (int)method.invoke(null, new Object[]{maze}));
  }
  catch (NoSuchMethodException e) {
    fail("Method does not exist");
  }
  catch (Exception e) {
    fail("Something weird happened");
  }
}
}

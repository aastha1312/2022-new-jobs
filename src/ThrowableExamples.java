public class ThrowableExamples {

    public static void main(String[] args) {
        try {
//          throw new NoSuchMethodException("Exception");
//          throw new Exception("Exception");
//          throw new IllegalStateException("RuntimeException");
//          throw new RuntimeException("RuntimeException");
            throw new NoSuchMethodError("Error");
//          throw new Error("Error");
//          throw new Throwable("Throwable");

        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " +  (e.getMessage().equals("RuntimeException") ? "Expected" : "Unexpected"));

        } catch (Exception e) {
            System.out.println("Caught Exception: " +  (e.getMessage().equals("Exception") ? "Expected" : "Unexpected"));

        } catch (Error e) {
            System.out.println("Caught Error: " +  (e.getMessage().equals("Error") ? "Expected" : "Unexpected"));

        } catch (Throwable e) {
            System.out.println("Caught Throwable: " +  (e.getMessage().equals("Throwable") ? "Expected" : "Unexpected"));
        }
    }
}
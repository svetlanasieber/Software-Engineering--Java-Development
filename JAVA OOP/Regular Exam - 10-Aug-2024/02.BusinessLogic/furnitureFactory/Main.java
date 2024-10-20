package furnitureFactory;

import furnitureFactory.core.Engine;
import furnitureFactory.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}

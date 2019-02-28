# Facade Pattern

### About
In these repositories, some design patterns are implemented to a mini game system for self education. They may not be suited to use in an actual game (directly anyway). However, it is good to have some examples underhand to take reference. And even if anyone wants to use them, you are welcome.

### Definition
**_Facade pattern_**, provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

### Description
We have worked hard and developed our own physics engine, audio engine, particle system and so on. Now, we want to use these systems and enrich our combat system. First, scene will be opened, then background music will start, characters will be placed, camera will move around characters, physics engine will be enabled and more. When we call them, it looks something like this;

```java
scene.open("Combat");
audioEngine.play("Background Music");
scene.placeCharacters();
camera.move();
physicsEngine.enable();
System.out.println();
```

And all these codes is just to enter combat mode. Also, there will be closing ceremony like this too. So why don't we just put all these codes under a method? Won't be a lot easier and cleaner that way? Lets create a class for it;

```java
public class CombatFacade {

    private PhysicsEngine physicsEngine;
    private AudioEngine audioEngine;
    private ParticleSystem particleSystem;
    private Scene scene;
    private Camera camera;
    private IService service;

    public CombatFacade(PhysicsEngine physicsEngine, AudioEngine audioEngine, ParticleSystem particleSystem, Scene scene, Camera camera, IService service){
        this.physicsEngine = physicsEngine;
        this.audioEngine = audioEngine;
        this.particleSystem = particleSystem;
        this.scene = scene;
        this.camera = camera;
        this.service = service;
    }

    public void start(){
        System.out.println("Preparing combat...");
        scene.open("Combat");
        audioEngine.play("Background Music");
        scene.placeCharacters();
        camera.move();
        physicsEngine.enable();
        System.out.println();
    }

    public void end(){
        System.out.println();
        particleSystem.start("Confetti");
        physicsEngine.disable();
        camera.move();
        audioEngine.stop("Background Music");
        // sends information about the combat
        service.sendRequest();
        scene.open("Map");
        System.out.println("Combat ended...");
    }

    // Getters
}
```

With doing this, we collected all subsystem under the same roof and entering or ending combat mode are became a lot easier. And if we need to access any 

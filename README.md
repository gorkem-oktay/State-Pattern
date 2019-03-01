# Facade Pattern

### About
In these repositories, some design patterns are implemented to a mini game system for self education. They may not be suited to use in an actual game (directly anyway). However, it is good to have some examples underhand to take reference. And even if anyone wants to use them, you are welcome.

### Definition
**_Facade pattern_**, provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

### Description
We have worked hard and implemented a game engine. Now, we want to use these engine and enrich our combat system. When players enter combat, scene will be prepared for it. Sprites for characters will be added, their position will be set, camera will be add, set and move and so on. When we call them, it looks something like this;

```java
scene.open("Combat");

scene.addSprite(player);
player.setPosition(0, 10);
player.playAnimation("Idle");

scene.addSprite(enemy);
enemy.setPosition(0, 110);
enemy.playAnimation("Idle");

audioEngine.play("Background Music");

scene.setCamera(camera);
camera.setPosition(10, 10);
camera.move();

physicsEngine.enable();
```

And all these codes is just to enter combat mode. Also, there will be closing ceremony like this too. So why don't we just put all these codes under a method? Won't be a lot easier and cleaner that way? Lets create a class for it;

```java
package com.zafiru.core;

import com.zafiru.components.Camera;
import com.zafiru.components.Scene;
import com.zafiru.components.Sprite;
import com.zafiru.services.IService;

public class CombatSceneFacade {

    private Scene scene;
    private Camera camera;
    private Sprite player, enemy;
    private PhysicsEngine physicsEngine;
    private AudioEngine audioEngine;
    private IService service;

    public CombatSceneFacade(Scene scene, Camera camera, Sprite player, Sprite enemy, PhysicsEngine physicsEngine, AudioEngine audioEngine, IService service){
        this.scene = scene;
        this.camera = camera;
        this.player = player;
        this.enemy = enemy;
        this.physicsEngine = physicsEngine;
        this.audioEngine = audioEngine;
        this.service = service;
    }

    public void start(){
        System.out.println("Preparing combat...");
        scene.open("Combat");

        scene.addSprite(player);
        player.setPosition(0, 10);
        player.playAnimation("Idle");

        scene.addSprite(enemy);
        enemy.setPosition(0, 110);
        enemy.playAnimation("Idle");

        audioEngine.play("Background Music");

        scene.setCamera(camera);
        camera.setPosition(10, 10);
        camera.move();

        physicsEngine.enable();

        System.out.println();
    }

    public void end(){
        System.out.println();
        physicsEngine.disable();
        camera.move();
        audioEngine.stop("Background Music");
        // sends information about the combat
        service.sendRequest();
        scene.open("Map");
        System.out.println("Combat ended...");
        System.out.println();
    }

    // Getters
}
```

With doing this, we collected all subsystem under the same roof and entering or ending combat mode are became a lot easier. And if any subsystem is specifically needed to access, we can do it via getter methods and make changes to meet that specific needs. And that is the Facade Pattern. It is so simple, yet powerful. It makes subsystems easier to use.

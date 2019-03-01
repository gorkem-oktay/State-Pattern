package com.zafiru.core;

import com.zafiru.components.Camera;
import com.zafiru.components.Scene;
import com.zafiru.components.Sprite;
import com.zafiru.services.IService;

public class CombatSceneFacade {

    private PhysicsEngine physicsEngine;
    private AudioEngine audioEngine;
    private Scene scene;
    private Camera camera;
    private IService service;
    private Sprite player, enemy;

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

    public PhysicsEngine getPhysicsEngine() {
        return physicsEngine;
    }

    public AudioEngine getAudioEngine() {
        return audioEngine;
    }

    public Scene getScene() {
        return scene;
    }

    public Camera getCamera() {
        return camera;
    }

    public IService getService() {
        return service;
    }

    public Sprite getPlayer() {
        return player;
    }

    public Sprite getEnemy() {
        return enemy;
    }
}

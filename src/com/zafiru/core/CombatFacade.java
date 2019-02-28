package com.zafiru.core;

import com.zafiru.components.Camera;
import com.zafiru.components.Scene;
import com.zafiru.services.IService;

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

    public PhysicsEngine getPhysicsEngine() {
        return physicsEngine;
    }

    public AudioEngine getAudioEngine() {
        return audioEngine;
    }

    public ParticleSystem getParticleSystem() {
        return particleSystem;
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
}

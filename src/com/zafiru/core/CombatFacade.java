package com.zafiru.core;

import com.zafiru.components.Camera;
import com.zafiru.components.Scene;
import com.zafiru.services.IService;

public class CombatFacade {

    private PhysicsEngine mPhysicsEngine;
    private AudioEngine mAudioEngine;
    private ParticleSystem mParticleSystem;
    private Scene mScene;
    private Camera mCamera;
    private IService mService;

    public CombatFacade(PhysicsEngine physicsEngine, AudioEngine audioEngine, ParticleSystem particleSystem, Scene scene, Camera camera, IService service){
        this.mPhysicsEngine = physicsEngine;
        this.mAudioEngine = audioEngine;
        this.mParticleSystem = particleSystem;
        this.mScene = scene;
        this.mCamera = camera;
        this.mService = service;
    }

    public void start(){
        System.out.println("Preparing combat...");
        mScene.open("Combat");
        mAudioEngine.play("Background Music");
        mScene.placeCharacters();
        mCamera.move();
        mPhysicsEngine.enable();
        System.out.println();
    }

    public void end(){
        System.out.println();
        mParticleSystem.start("Confetti");
        mPhysicsEngine.disable();
        mCamera.move();
        mAudioEngine.stop("Background Music");
        // sends information about the combat
        mService.sendRequest();
        mScene.open("Map");
        System.out.println("Combat ended...");
    }

    public PhysicsEngine getPhysicsEngine() {
        return mPhysicsEngine;
    }

    public AudioEngine getAudioEngine() {
        return mAudioEngine;
    }

    public ParticleSystem getParticleSystem() {
        return mParticleSystem;
    }

    public Scene getScene() {
        return mScene;
    }

    public Camera getCamera() {
        return mCamera;
    }

    public IService getService() {
        return mService;
    }
}

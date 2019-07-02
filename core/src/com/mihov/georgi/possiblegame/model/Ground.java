package com.mihov.georgi.possiblegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mihov.georgi.possiblegame.PossibleGame;
import com.mihov.georgi.possiblegame.assets.Assets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ground {
    private PossibleGame possibleGame;
    private World physicsWorld;
    private List<Tile> groundArr;
    private float y;
    private Stage stage;
    //this shouldn't be here
    private Texture appearance;
    private float worldWidth;


    public Ground(PossibleGame possibleGame, World physicsWorld, Stage stage, float y) {
        this. possibleGame = possibleGame;
        this.physicsWorld = physicsWorld;
        this.stage = stage;
        this.y = y;
        this.appearance = possibleGame.assets.manager.get(Assets.ground, Texture.class);
        float ratio = (float) Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth() ;
        this.worldWidth = PossibleGame.WORLD_HEIGHT / ratio;

        this.initGround();
    }


    private void initGround(){
        groundArr = new ArrayList<Tile>(10);
        Random random = new Random();
        //int index = random.nextInt(10);
        for(int i = 0; i < 10; i++){
           // if(i != index) {
                Tile groundTile = new Tile(possibleGame, physicsWorld, appearance, i * 4 + 1, y, 4, 0.5f);
                groundArr.add(groundTile);
            //}

        }
        for(Tile e: groundArr){
            stage.addActor(e);
        }
    }

    public void regenrate()
    {
        if(this.groundArr.get(0).getX() < stage.getCamera().position.x - worldWidth / 2){
            groundArr.remove(0);
            System.out.println("Out");
        }
        if(groundArr.size() == 9){
            Tile groundTile = new Tile(possibleGame, physicsWorld, appearance, (groundArr.get(groundArr.size() - 1).getX() + groundArr.get(groundArr.size() - 1).getWidth()) - 0.1f, y, 4, 0.5f);
            groundArr.add(groundTile);
            stage.addActor(groundTile);
        }
    }




}

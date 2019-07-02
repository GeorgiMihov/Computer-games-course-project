package com.mihov.georgi.possiblegame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mihov.georgi.possiblegame.PossibleGame;
import com.mihov.georgi.possiblegame.assets.Assets;

import javafx.geometry.Pos;

public class MenuScreen implements Screen {

    private PossibleGame possibleGame;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture menuBackground;

    public MenuScreen(PossibleGame possibleGame) {
        this.possibleGame = possibleGame;
    }

    @Override
    public void show() {
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, PossibleGame.WIDTH, PossibleGame.HEIGHT);
        this.camera.update();
        this.menuBackground = possibleGame.assets.manager.get(Assets.menuBackground, Texture.class);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(39/255f, 39/255f, 39/255f, 1); // 	0, 51, 102
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        camera.update();
        batch.begin();
        batch.draw(menuBackground,0,0);
        batch.end();

        if(Gdx.input.justTouched()){
            possibleGame.gameState = PossibleGame.GAME_STATE.PLAYING;
            possibleGame.setScreen(new GameScreen(possibleGame));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();//CHECK THIS
    }
}

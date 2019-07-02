package com.mihov.georgi.possiblegame.listener;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mihov.georgi.possiblegame.model.Player;

public class B2dContactListener implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        String classA = contact.getFixtureA().getBody().getUserData().getClass().getName();
        String classB = contact.getFixtureB().getBody().getUserData().getClass().getName();
        String classC = contact.getFixtureB().getBody().getUserData().getClass().getName();

        if(classA.equals("com.mihov.georgi.possiblegame.model.Player") && classB.equals("com.mihov.georgi.possiblegame.model.Tile")){
            Player player = (Player)(contact.getFixtureA().getBody().getUserData());
            player.resetJumpCounter();
        }
        else if(classA.equals("com.mihov.georgi.possiblegame.model.Tile") && classB.equals("com.mihov.georgi.possiblegame.model.Player")){
            Player player = (Player)(contact.getFixtureB().getBody().getUserData());
            player.resetJumpCounter();
        }



    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}

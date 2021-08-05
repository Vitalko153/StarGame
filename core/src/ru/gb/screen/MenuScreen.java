package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

import ru.gb.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float SPEED = 0.02f;

    private Texture background;
    private Texture img;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 touch;

    @Override
    public void show() {
        super.show();
        background = new Texture("new.jpg");
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        v = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if (touch.dst(pos) > SPEED){
            pos.add(v);
        } else {
            pos.set(touch);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        background.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight()-screenY);
        v.set(touch.cpy().sub(pos)).scl(SPEED);
        return false;
    }
}

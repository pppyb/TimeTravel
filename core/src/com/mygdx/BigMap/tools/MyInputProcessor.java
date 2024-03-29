package com.mygdx.BigMap.tools;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.BigMap.Communication.NpcCommunication;
import com.mygdx.SmallMap.LevelFrame.CurState;

public class MyInputProcessor implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        if (button == Input.Buttons.LEFT && CurState.curLevelNum==1) {
            onMouseDown();
            return true;
        }
        return false;
    }
//    private void onMouseDown1(){
//        NpcCommunication.BigManCount++;
//    }
    private void onMouseDown() {
        NpcCommunication.BigManCount++;
        NpcCommunication.communicationCount++;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
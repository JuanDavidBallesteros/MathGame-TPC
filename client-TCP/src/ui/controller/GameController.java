package ui.controller;

import ui.view.GameView;

public class GameController {
    
    private GameView view;

    public GameController(GameView view) {
        this.view = view;
        
        btnActions();
    }

    private void btnActions(){

        view.getValidateBtn().setOnAction( e -> {
            System.out.println("Hola");
        });
    }
}

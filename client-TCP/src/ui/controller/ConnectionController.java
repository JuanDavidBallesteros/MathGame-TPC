package ui.controller;

import ui.view.ConnectionView;

public class ConnectionController {

    private ConnectionView view;

    public ConnectionController(ConnectionView view) {
        this.view = view;

        view.getCloseBtn().setOnAction(e -> {
            System.exit(0);
        });

        view.getPlayBtn().setOnAction(e -> {
            System.out.println("Hola");
        });

    }

}

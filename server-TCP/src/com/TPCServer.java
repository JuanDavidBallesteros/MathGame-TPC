package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TPCServer extends Thread implements Receptor.OnMessageListener {

    // SINGLETON
	private static TPCServer instance = null;
    public static final int DISPATCHER_PORT = 5000;

	private TPCServer() {
		sessions = new ArrayList<>();
	}

	public static synchronized TPCServer getInstance() {
		if (instance == null) {
			instance = new TPCServer();
		}
		return instance;
	}

	// GLOBAL
	private ServerSocket server;
	private ArrayList<Session> sessions;

	@Override
	public void run() {
		try {
			server = new ServerSocket(DISPATCHER_PORT);

			while (true) {
				System.out.println("Esperando en el puerto " + DISPATCHER_PORT);
				Socket socket = server.accept();
				System.out.println("Nuevo cliente conectado");

				Session session = new Session(socket);
				sessions.add(session);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendBroadcast(String msg) {
		for (Session session : sessions) {
			session.getEmisor().sendMessage(msg);
		}
	}

	public void sendDirectTwo(Session sessionTo, Session sessionFrom, String msg) {

		for (Session session : sessions) {
			if (session == sessionTo || session == sessionFrom) {
				session.getEmisor().sendMessage(msg);
			}
		}
	}

	public void sendDirectOne(Session sessionTo, String msg) {

		for (Session session : sessions) {
			if (session.equals(sessionTo)) {
				session.getEmisor().sendMessage(msg);
			}
		}
	}

	// Server Actions
	@Override
	public void onMessage(Session session, String msg) {
		System.out.println(msg);
		
	}

	
}

package com.kleim;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ConsoleListenerStarter {

    private final OperationsConsoleListener operationsConsoleListener;
    private Thread consoleListenerThread;

    public ConsoleListenerStarter(OperationsConsoleListener operationsConsoleListener) {
        this.operationsConsoleListener = operationsConsoleListener;
    }

    @PostConstruct
    public void postConstruct(){
       this.consoleListenerThread = new Thread(() -> {
           operationsConsoleListener.startListen();
           operationsConsoleListener.consoleListener();
       });
       consoleListenerThread.start();
    }

    @PreDestroy
    public void preDestroy(){
       consoleListenerThread.interrupt();
       operationsConsoleListener.endListen();
    }
}

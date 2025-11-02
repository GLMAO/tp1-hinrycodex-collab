package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

public class CompteARebours implements TimerChangeListener {
    private int compteur;
    private TimerService timerService;
    private String name;
    
    public CompteARebours(String name, int valeurInitiale, TimerService timerService) {
        this.name = name;
        this.compteur = valeurInitiale;
        this.timerService = timerService;
        this.timerService.addTimeChangeListener(this);
        System.out.println("CompteARebours " + name + " initialized with value: " + compteur);
    }
    
    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        // Decrement only when seconds change
        if (prop.equals(TimerChangeListener.SECONDE_PROP)) {
            if (compteur > 0) {
                compteur--;
                System.out.println("CompteARebours " + name + ": " + compteur);
            } else if (compteur == 0) {
                System.out.println("CompteARebours " + name + ": Finished!");
                seDesinscrire();
            }
        }
    }
    
    public void seDesinscrire() {
        timerService.removeTimeChangeListener(this);
        System.out.println("CompteARebours " + name + " unsubscribed from TimerService");
    }
    
    public int getCompteur() {
        return compteur;
    }
}
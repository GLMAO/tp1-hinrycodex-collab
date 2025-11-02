package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        testDuTimeService();
    }
    
    private static void testDuTimeService() {
        // Create TimerService instance
        TimerService timerService = new DummyTimeServiceImpl();
        
        System.out.println("=== Testing Observer Pattern ===\n");
        
        // Create multiple Horloge instances (Part c - step 4)
        Horloge horloge1 = new Horloge("Num 1", timerService);
        Horloge horloge2 = new Horloge("Num 2", timerService);
        Horloge horloge3 = new Horloge("Num 3", timerService);
        
        System.out.println();
        
        // Create CompteARebours instances (Part d - step 3)
        CompteARebours compte1 = new CompteARebours("Compte1", 5, timerService);
        CompteARebours compte2 = new CompteARebours("Compte2", 10, timerService);
        CompteARebours compte3 = new CompteARebours("Compte3", 15, timerService);
        
        System.out.println("\n=== Observers are now running ===");
        System.out.println("Horloges will display time every second");
        System.out.println("CompteARebours will countdown and unsubscribe at 0\n");
        
        // Let it run for 20 seconds to see all counters finish
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=== Test completed ===");
        System.exit(0);
    }
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
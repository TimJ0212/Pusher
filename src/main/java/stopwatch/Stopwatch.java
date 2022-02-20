package stopwatch;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Eine Stoppuhr um die relative Laufzeit von Algorithmen einfach vergleichen zu können. <br>
 * {@link Stopwatch#start()} bzw. der Konstruktor starten diese. <br>
 * {@link Stopwatch#stop()} liefert die vergangene Zeit.
 */
public class Stopwatch {

    /**
     * Der Wert, zu der die Stoppuhr gestartet wurde.
     */
    private LocalDateTime from;

    /**
     * Konstruktor. Liefert eine {@link Stopwatch}. Diese wird automatisch gestartet. <br>
     * Optional kann mit {@link Stopwatch#start()} gestartet werden.
     */
    public Stopwatch() {
        this.from = LocalDateTime.now();
    }

    /**
     * Startet die Stoppuhr erneut.
     */
    public void start() {
        this.from = LocalDateTime.now();
    }

    /**
     * "Stoppt" die Stoppuhr. Kann aber mehrfach aufgerufen werden und liefert jeweils den aktuellen Wert.
     */
    public long stop() {
        return ChronoUnit.NANOS.between(from, LocalDateTime.now());
    }

}

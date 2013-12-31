package ua.kpi.schedule.util.formatters;

import org.springframework.format.Parser;
import org.springframework.format.Printer;

/**
 * @author AnastasiyaR
 */
public interface Formatter<T> extends Printer<T>, Parser<T> {
}
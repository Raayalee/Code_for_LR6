package command;

/**
 * Інтерфейс команди - визначає контракт для всіх команд
 */

public interface Command {

    /**
     * Повертає опис команди для help() меню
     */
    String getDescription();

    /**
     * Виконує логіку команди
     * @param parameters параметри команди (може бути порожнім)
     */
    void execute(String parameters);
}
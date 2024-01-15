package com.example.myapplication.background;

public class TareaSegundoPlano {

    public interface TaskListener {
        void onTaskComplete(String result);
    }

    private TaskListener taskListener;

    public TareaSegundoPlano(TaskListener listener) {
        this.taskListener = listener;
    }

    public void performBackgroundTask(String inputParameter) {
        String result = "Resultado de la tarea con parámetro: " + inputParameter;

        // Llamar al método de la interfaz para informar sobre la finalización de la tarea
        if (taskListener != null) {
            taskListener.onTaskComplete(result);
        }
    }
}

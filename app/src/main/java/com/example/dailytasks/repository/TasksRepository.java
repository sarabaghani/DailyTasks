package com.example.dailytasks.repository;

import com.example.dailytasks.TaskState;
import com.example.dailytasks.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TasksRepository {
    Random rand = new Random();
    public static int taskNum;
    public static String taskName;

    private TasksRepository() {
        mTasks = new ArrayList<>();
        for (int i = 0; i < taskNum; i++) {
            Task task = new Task();
            //set random task state
            int r = rand.nextInt(10);
            if (r <= 3)
                setRandomState(task, TaskState.DONE);
            else if (r < 7 && r > 3)
                setRandomState(task, TaskState.DOING);
            else
                setRandomState(task, TaskState.TODO);
            task.setName(taskName + (i + 1));


            mTasks.add(task);
        }
    }

    private void setRandomState(Task task, TaskState s) {
        switch (s) {
            case DOING:
                task.setState("DOING");
                break;
            case DONE:
                task.setState("DONE");
                break;
            case TODO:
                task.setState("TODO");
                break;
        }
    }

    private static TasksRepository sInstance;

    public static TasksRepository getInstance() {
        if (sInstance == null) {
            sInstance = new TasksRepository();
        }
        return sInstance;
    }

    private List<Task> mTasks;

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
    }

}

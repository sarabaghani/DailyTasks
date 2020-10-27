package com.example.dailytasks.controllers.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailytasks.R;
import com.example.dailytasks.model.Task;
import com.example.dailytasks.repository.TasksRepository;

import java.util.List;


public class TaskListFrag extends Fragment {
    private RecyclerView mRecyclerView;

    public TaskListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent startIntent = getActivity().getIntent();
        TasksRepository.taskName = startIntent.getStringExtra(MainFragment.EXTRA_USERNAME);
        String s = startIntent.getStringExtra(MainFragment.EXTRA_NUMBER);
        TasksRepository.taskNum = Integer.parseInt(s);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        findViews(view);
        initViews();
        return view;
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TasksRepository tasksRepository = TasksRepository.getInstance();
        List<Task> tasks = tasksRepository.getTasks();
        TaskAdapter taskAdapter = new TaskAdapter(tasks);
        mRecyclerView.setAdapter(taskAdapter);
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.rv_task_list);
    }

    private class TaskHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewName;
        public TextView mTextViwState;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.task_name_txtview);
            mTextViwState = itemView.findViewById(R.id.task_state_txtview);
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

        private List<Task> mTasks;

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        public List<Task> getTasks() {
            return mTasks;
        }

        public void setTasks(List<Task> tasks) {
            mTasks = tasks;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.tak_row_list, parent, false);
            TaskHolder taskHolder = new TaskHolder(view);
            return taskHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {

            Task task = mTasks.get(position);
            holder.mTextViewName.setText(task.getName());
            holder.mTextViwState.setText(task.getState());

            if (mTasks.indexOf(task) % 2 == 0) {
                holder.itemView.setBackgroundColor(Color.rgb(152, 68, 158));
           /*     holder.mTextViwState.setBackgroundColor(Color.rgb(152, 68, 158));
                holder.mTextViewName.setBackgroundColor(Color.rgb(152, 68, 158));*/
            } else {
                holder.itemView.setBackgroundColor(Color.rgb(250, 134, 202));
               /* holder.mTextViwState.setBackgroundColor(Color.rgb(250, 134, 202));
                holder.mTextViewName.setBackgroundColor(Color.rgb(250, 134, 202));*/
            }
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }
}
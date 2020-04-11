package com.naver.exam.problem1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * CreateDate：2020/4/11 <br/>
 * Author：WangHao <br/>
 * Description:
 **/
public class TaskPool {

    private Set<Task> tasks = new HashSet<>();

    private Map<Task, Set<Task>> dependencyMap = new HashMap<>();

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Map<Task, Set<Task>> getDependencyMap() {
        return dependencyMap;
    }

    public void setDependencyMap(Map<Task, Set<Task>> dependencyMap) {
        this.dependencyMap = dependencyMap;
    }

    /**
     * add task to task pool
     *
     * @param task task
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * add task dependency to dependency pool
     *
     * @param task       task
     * @param dependTask dependency task
     */
    public void addDependency(Task task, Task dependTask) {
        Set<Task> dependencyTasks = dependencyMap.get(task);
        if (dependencyTasks == null) {
            dependencyTasks = new HashSet<>();
            dependencyTasks.add(dependTask);
            dependencyMap.put(task, dependencyTasks);
        } else if (!dependencyTasks.contains(dependTask)) {
            dependencyTasks.add(dependTask);
        }
    }

    public void removeTask(Task task) {
        if (!tasks.contains(task)) {
            return;
        }
        if (dependencyMap.containsKey(task)) {
            dependencyMap.remove(task);
        }
        for (Set<Task> set : dependencyMap.values()) {
            if (set.contains(task)) {
                set.remove(task);
            }
        }
    }
}

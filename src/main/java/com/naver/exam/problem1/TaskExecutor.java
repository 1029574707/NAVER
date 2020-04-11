package com.naver.exam.problem1;

import javax.xml.ws.FaultAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * CreateDate：2020/4/11 <br/>
 * Author：WangHao <br/>
 * Description:
 **/
public class TaskExecutor {

    public void execution(TaskPool taskPool) {

        String result = "";
        while (true) {
            List<Task> needExecuteTaskPool = new ArrayList<>();
            for (Task task : taskPool.getTasks()) {
                if (!task.isDone()) {
                    Set<Task> dependencyTasks = taskPool.getDependencyMap().get(task);
                    if (dependencyTasks == null || dependencyTasks.isEmpty()) {
                        //
                        needExecuteTaskPool.add(task);
                    } else {
                        //
                        boolean needExecute = true;
                        for (Task dependencyTask : dependencyTasks) {
                            if (!dependencyTask.isDone()) {
                                needExecute = false;
                                break;
                            }
                        }
                        if (needExecute) {
                            needExecuteTaskPool.add(task);
                        }
                    }
                }
            }
            if (!needExecuteTaskPool.isEmpty()) {
                for (Task task : needExecuteTaskPool) {
                    task.execute();
                    result += task.getName() + ",";
                }
            } else {
                break;
            }
        }
        System.out.println(result.replaceAll(",$", ","));
    }
}

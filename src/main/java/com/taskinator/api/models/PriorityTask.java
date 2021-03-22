package com.taskinator.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "priority_task")
@NoArgsConstructor
@AllArgsConstructor
public class PriorityTask {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "priorityTasks", fetch = FetchType.LAZY)
    private Set<Task> task;
}

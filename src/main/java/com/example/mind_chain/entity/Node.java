package com.example.mind_chain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 节点表
 * </p>
 *
 * @author 许志龙
 * @since 2024-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 节点唯一标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 节点所属笔记的外键
     */
    private Integer noteId;

    /**
     * 节点所属模板的外键
     */
    private Integer templateId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点层级
     */
    private Integer level;

    /**
     * 节点上下文
     */
    private String context;

    /**
     * 父节点的id(一个节点可能有多个父节点id，所以用英文逗号分割)
     */
    private String parentId;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 截止时间
     */
    private String deadline;

    /**
     * 状态(1 可执行,2 被阻塞,3 已完成)
     */
    private Integer status;

    /**
     * 状态详情(1 本身可执行-浅绿色,2 有子任务可执行-浅蓝色,3 事件阻塞-红色,4 时间阻塞-红色 ,
     * 5 属于下方的同级收敛节点及其子节点-浅红色,6 当前节点全部的直接子节点被阻塞,7 当前节点的父节点被阻塞，存在被直接阻塞的节点)
     * 直接阻塞为红色,间接阻塞为浅红色
     * 一个节点处于被阻塞状态时，可能同时有多个原因，所以用英文逗号分割
     */
    private String details;

    /**
     * 事件阻塞的具体原因
     */
    private String blockedReason;

    /**
     * 时间阻塞的具体时间
     * @return
     */
    private String blockedTime;
}

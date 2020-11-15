package com.ronnie.equipment.info.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "equipment_info")
@Data
public class EquipmentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
}

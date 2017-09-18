package com.camera.of.city.mvc.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "camera")
public class Camera implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_device")
    private Long idDevice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address")
    private Address address;

    @OneToOne(mappedBy = "camera")
    private Photo photo;

    public Camera() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Long idDevice) {
        this.idDevice = idDevice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}

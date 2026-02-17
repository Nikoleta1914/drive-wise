package com.project.drivewise.entities;

import com.project.drivewise.entities.enums.PointsReason;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "points_ledger", schema = "drive_wise")
public class PointsLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "points_delta", nullable = false)
    private Integer pointsDelta;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason", nullable = false)
    private PointsReason reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_event_id")
    private DrivingEvent refEvent;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata")
    private Map<String, Object> metadata = new HashMap<>();

    public PointsLedger() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPointsDelta() {
        return pointsDelta;
    }

    public void setPointsDelta(Integer pointsDelta) {
        this.pointsDelta = pointsDelta;
    }

    public PointsReason getReason() {
        return reason;
    }

    public void setReason(PointsReason reason) {
        this.reason = reason;
    }

    public DrivingEvent getRefEvent() {
        return refEvent;
    }

    public void setRefEvent(DrivingEvent refEvent) {
        this.refEvent = refEvent;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
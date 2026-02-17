package com.project.drivewise.entities;

import com.project.drivewise.entities.enums.TelemetrySource;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "telemetry_points", schema = "drive_wise")
public class TelemetryPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(name = "recorded_at", nullable = false)
    private OffsetDateTime recordedAt;

    @Column(name = "received_at", nullable = false)
    private OffsetDateTime receivedAt;

    @Column(name = "lat", nullable = false)
    private Double lat;

    @Column(name = "lng", nullable = false)
    private Double lng;

    @Column(name = "speed_mps", nullable = false)
    private Double speedMps;

    @Column(name = "heading_deg", nullable = false)
    private Double headingDeg;

    @Column(name = "accuracy_m", nullable = false)
    private Double accuracyM;

    @Enumerated(EnumType.STRING)
    @Column(name = "sourcer", nullable = false)
    private TelemetrySource source;


    public TelemetryPoint() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public OffsetDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(OffsetDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public OffsetDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(OffsetDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getSpeedMps() {
        return speedMps;
    }

    public void setSpeedMps(Double speedMps) {
        this.speedMps = speedMps;
    }

    public Double getHeadingDeg() {
        return headingDeg;
    }

    public void setHeadingDeg(Double headingDeg) {
        this.headingDeg = headingDeg;
    }

    public Double getAccuracyM() {
        return accuracyM;
    }

    public void setAccuracyM(Double accuracyM) {
        this.accuracyM = accuracyM;
    }

    public TelemetrySource getSource() {
        return source;
    }

    public void setSource(TelemetrySource source) {
        this.source = source;
    }
}
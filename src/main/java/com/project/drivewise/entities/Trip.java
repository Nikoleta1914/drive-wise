package com.project.drivewise.entities;

import com.project.drivewise.entities.enums.TripStatus;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "trips", schema = "drive_wise")
public class Trip {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TripStatus status;

    @Column(name = "start_time")
    private OffsetDateTime startTime;

    @Column(name = "end_time")
    private OffsetDateTime endTime;

    @Column(name = "origin_lng")
    private Double originLng;

    @Column(name = "origin_lat")
    private Double originLat;

    @Column(name = "destination_lat")
    private Double destinationLat;

    @Column(name = "destination_lng")
    private Double destinationLgn;

    @Column(name = "route_destination_m")
    private Integer routeDestinationM;

    @Column(name = "route_destination_s")
    private Integer routeDestinationS;

    @Column(name = "route_provider")
    private String routeProvider;

    @Column(name = "route_polyline")
    private String routePolyline;

    @Column(name = "route_computed_at")
    private OffsetDateTime routeComputedAt;

    @Column(name = "actual_distanceM")
    private Integer actualDistanceM;

    @Column(name = "actual_distance_s")
    private Integer actualDistanceS;

    @Column(name = "score_total", nullable = false)
    private Integer scoreTotal;

    public Trip() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getOriginLng() {
        return originLng;
    }

    public void setOriginLng(Double originLng) {
        this.originLng = originLng;
    }

    public Double getOriginLat() {
        return originLat;
    }

    public void setOriginLat(Double originLat) {
        this.originLat = originLat;
    }

    public Double getDestinationLat() {
        return destinationLat;
    }

    public void setDestinationLat(Double destinationLat) {
        this.destinationLat = destinationLat;
    }

    public Double getDestinationLgn() {
        return destinationLgn;
    }

    public void setDestinationLgn(Double destinationLgn) {
        this.destinationLgn = destinationLgn;
    }

    public Integer getRouteDestinationM() {
        return routeDestinationM;
    }

    public void setRouteDestinationM(Integer routeDestinationM) {
        this.routeDestinationM = routeDestinationM;
    }

    public Integer getRouteDestinationS() {
        return routeDestinationS;
    }

    public void setRouteDestinationS(Integer routeDestinationS) {
        this.routeDestinationS = routeDestinationS;
    }

    public String getRouteProvider() {
        return routeProvider;
    }

    public void setRouteProvider(String routeProvider) {
        this.routeProvider = routeProvider;
    }

    public String getRoutePolyline() {
        return routePolyline;
    }

    public void setRoutePolyline(String routePolyline) {
        this.routePolyline = routePolyline;
    }

    public OffsetDateTime getRouteComputedAt() {
        return routeComputedAt;
    }

    public void setRouteComputedAt(OffsetDateTime routeComputedAt) {
        this.routeComputedAt = routeComputedAt;
    }

    public Integer getActualDistanceM() {
        return actualDistanceM;
    }

    public void setActualDistanceM(Integer actualDistanceM) {
        this.actualDistanceM = actualDistanceM;
    }

    public Integer getActualDistanceS() {
        return actualDistanceS;
    }

    public void setActualDistanceS(Integer actualDistanceS) {
        this.actualDistanceS = actualDistanceS;
    }

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }
}
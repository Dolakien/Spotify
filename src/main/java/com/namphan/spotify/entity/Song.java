package com.namphan.spotify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "Songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int songId;

    @Column(columnDefinition = "varchar(50)")
    private String songName;

    @Column
    private int yearRelease;

    @Column(columnDefinition = "varchar(1000)")
    private String image;

    @Column
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "artistId")
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "song")
    @JsonIgnore
    private Collection<PlaylistSong> playlistSongs;

    @OneToMany(mappedBy = "song")
    private Collection<Album> albums;


}

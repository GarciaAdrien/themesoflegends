package com.hcorp.themesoflegends.service;

import com.hcorp.themesoflegends.dto.MusicDto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import com.hcorp.themesoflegends.dto.MusicDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Getter


    public class MusicStorageService {
        // Liste pour stocker les musiques
        public List<MusicDto> fetchMusicFromDatabase() {
            List<MusicDto> musics = new ArrayList<>();
            // Connection à la base de données
            try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BDLOL;user=DESKTOP-PBS36K4\\Adrien;password=;integratedSecurity=false;encrypt=false;trustServerCertificate=true;")) {
                // Appel de la procédure stockée
                try (CallableStatement statement = connection.prepareCall("{CALL ps_get_music 0,0 ,null}")) {
                    // Exécution de la procédure stockée
                    try (ResultSet resultSet = statement.executeQuery()) {
                        // Parcours des résultats et ajout des musiques à la liste
                        while (resultSet.next()) {
                            String id = resultSet.getString("id");
                            String name = resultSet.getString("name");
                            String date = resultSet.getString("date");
                            String type = resultSet.getString("type");
                            String alias = resultSet.getString("alias");
                            musics.add(new MusicDto(id, name, date, type, List.of("test")));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return musics;
        }
    }


package org.fordltc.chessgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;


@SpringBootApplication
@RestController
public class ChessGameApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChessGameApplication.class, args);
    }

    @Configuration
    public class WebConfiguration implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedMethods("*");
        }
    }

    @GetMapping("/getBoard")
    public String getBoard() {
        ChessBoard chessBoard = ChessBoard.getInstance();
        return Arrays.deepToString(chessBoard.board);
    }

    @GetMapping("/changeBoard")
    public String changeBoard() {
        ChessBoard chessBoard = ChessBoard.getInstance();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard.board[i][j]++;
            }
        }
        return Arrays.deepToString(chessBoard.board);
    }
}

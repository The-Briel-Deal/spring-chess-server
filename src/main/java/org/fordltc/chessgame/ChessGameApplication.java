package org.fordltc.chessgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Map;


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

    @PostMapping("/swapPiece")
    public String swapPiece(@RequestBody Map<String, Integer> payload) {
        ChessBoard chessBoard = ChessBoard.getInstance();
        int rowOneNum = payload.get("rowOne");
        int colOneNum = payload.get("colOne");
        int rowTwoNum = payload.get("rowTwo");
        int colTwoNum = payload.get("colTwo");
        int pieceOne = chessBoard.board[rowOneNum][colOneNum];
        int pieceTwo = chessBoard.board[rowTwoNum][colTwoNum];
        chessBoard.board[rowOneNum][colOneNum] = pieceTwo;
        chessBoard.board[rowTwoNum][colTwoNum] = pieceOne;
        return Arrays.deepToString(chessBoard.board);
    }
}

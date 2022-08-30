package org.fordltc.chessgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/swapPiece")
    public String swapPiece(@RequestParam(value = "rowOne", defaultValue = "0") String rowOne,
                            @RequestParam(value = "colOne", defaultValue = "0") String colOne,
                            @RequestParam(value = "rowTwo", defaultValue = "0") String rowTwo,
                            @RequestParam(value = "colTwo", defaultValue = "0") String colTwo) {
        ChessBoard chessBoard = ChessBoard.getInstance();
        int rowOneNum = Integer.parseInt(rowOne);
        int colOneNum = Integer.parseInt(colOne);
        int rowTwoNum = Integer.parseInt(rowTwo);
        int colTwoNum = Integer.parseInt(colTwo);
        int pieceOne = chessBoard.board[rowOneNum][colOneNum];
        int pieceTwo = chessBoard.board[rowTwoNum][colTwoNum];
        chessBoard.board[rowOneNum][colOneNum] = pieceTwo;
        chessBoard.board[rowTwoNum][colTwoNum] = pieceOne;

        return Arrays.deepToString(chessBoard.board);
    }
}

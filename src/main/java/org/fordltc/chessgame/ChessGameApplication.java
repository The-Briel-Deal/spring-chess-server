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
    public String swapPiece(@RequestParam(value = "row", defaultValue = "0") String row, @RequestParam(value = "col", defaultValue = "0") String col,@RequestParam(value = "newVal", defaultValue = "0") String newVal) {
        ChessBoard chessBoard = ChessBoard.getInstance();
        int rowNum = Integer.parseInt(row);
        int colNum = Integer.parseInt(col);
        int newValNum = Integer.parseInt(newVal);
        chessBoard.board[rowNum][colNum] = newValNum;
        return Arrays.deepToString(chessBoard.board);
    }
}

package kakao.recruit.n2019;

public class DartGame {

    public static int getGameScore( String gameInfo){        
        String[][] game_info_detail = new String[3][3];        
        int idxGame = 0;
        // 문자열을 하나씩 파싱하는 방법을 썼다. 정규식에 비해 길지만 성능은 나을것이라 생각해서...
        for(int i = 0; i < gameInfo.length();i++){
            char chr = gameInfo.charAt(i);
            if( Character.isDigit(chr)){
                game_info_detail[idxGame][0] = (game_info_detail[idxGame][0]!=null?game_info_detail[idxGame][0]:"") + String.valueOf(chr);
            }else{                
                if( chr == 'S' || chr == 'D' || chr == 'T'){
                    game_info_detail[idxGame][1] = String.valueOf(chr);
                }else{
                    game_info_detail[idxGame][2] = String.valueOf(chr);
                }
                if( i + 1 < gameInfo.length()){
                    if( Character.isDigit(gameInfo.charAt(i+1))){
                        idxGame++;
                    }
                }
            }            
        }

        int[] scoreResult = new int[game_info_detail.length];
        int totScore = 0;
        for(int i = 0; i < game_info_detail.length;i++){
            int dartArea = 1;
            if( "D".equals(game_info_detail[i][1]) ){
                dartArea = 2;
            }else if( "T".equals(game_info_detail[i][1])  ){
                dartArea = 3;
            }
            int spPoint = 1;
            if( game_info_detail[i][2] != null ){
                if( "*".equals(game_info_detail[i][2])  ){
                    spPoint = 2;
                    if( i > 0 ){
                        scoreResult[i-1] = scoreResult[i-1] * spPoint;
                    }                    
                }else if( "#".equals(game_info_detail[i][2]) ){
                    spPoint = -1;
                }
            }
            //System.out.println( game_info_self[i][0] + " ^ " + dartArea + " * " + spPoint );
            scoreResult[i] = (int) (Math.pow(Integer.parseInt(game_info_detail[i][0]), dartArea) * spPoint);            
        }

        for(int i = 0; i < scoreResult.length;i++){
            totScore += scoreResult[i];
        }
        //System.out.println("totScore : "+totScore);
        return totScore;
    }
    public static void main(String[] args) {
        
        System.out.println("DartGame!!!");

        String[] dartResults = new String[]{
            "1S2D*3T"
            , "1D2S#10S"
            , "1D2S0T"
            , "1S*2T*3S"
            , "1D#2S*3S"
            , "1T2D3D#"
            , "1D2S3T*"
        };
        for(int i = 0; i < dartResults.length;i++){
            System.out.println( (i+1) + " : " + dartResults[i] + " : " + getGameScore( dartResults[i] ) );
        }        
    }
}

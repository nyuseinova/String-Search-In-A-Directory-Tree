package com.company;

public class CharacterReader {

    private  Reader reader;

    public CharacterReader(Path f) throws UnsupportedEncodingException,
                                          FileNotFoundException {
        this.reader = new InputStreamReader(new FileInputStream(f.toString()),"UTF-8");
    }

    public Character getNextChar() throws IOException {
        int i = this.reader.read();
        if(i == -1){
            this.reader.close();
            return null;
        }
        return new Character((char i))
    }
}

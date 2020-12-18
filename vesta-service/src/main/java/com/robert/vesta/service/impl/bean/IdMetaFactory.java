package com.robert.vesta.service.impl.bean;

public class IdMetaFactory {

    private static IdMeta maxPeak = new IdMeta((byte) 10, (byte) 20, (byte) 30, (byte) 2, (byte) 1, (byte) 1);

    private static IdMeta minGranularity = new IdMeta((byte) 10, (byte) 10, (byte) 40, (byte) 2, (byte) 1, (byte) 1);

    public static IdMeta getIdMeta(IdType type) {
        if (IdType.MAX_PEAK.equals(type)) {
            return maxPeak;
        } else if (IdType.MIN_GRANULARITY.equals(type)) {
            return minGranularity;
        }
        return null;
    }



    private static String toBinary(int num){
        String result="";
        int i=0;
        int v;
        while ((v=(1<<i++))<num){
            if ((num&v)==0){
                result=0+result;
            }else{
                result=1+result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IdMeta idMeta=IdMetaFactory.maxPeak;
        System.out.println("MachineBits:"+toBinary((int)idMeta.getMachineBitsMask()));
        System.out.println("SeqBits"+toBinary((int)idMeta.getSeqBitsMask()));
        System.out.println("TimeBits"+toBinary((int)idMeta.getTimeBitsMask()));
        System.out.println("MethodBits"+toBinary((int)idMeta.getGenMethodBitsMask()));
        System.out.println("TypeBits"+toBinary((int)idMeta.getTypeBitsMask()));
        System.out.println("VersionBits"+toBinary((int)idMeta.getVersionBitsMask()));
        System.out.println(" -1L"+toBinary((int)(-1L<<1)));


    }
}

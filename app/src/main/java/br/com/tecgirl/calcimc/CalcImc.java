package br.com.tecgirl.calcimc;

import java.text.DecimalFormat;

/**
 * Classe que realiza o calculo do IMC
 * Created by rafael on 14/11/2016.
 * <p>
 * referencias:
 * http://nutricionistairisnunes.blogspot.com.br/2011/07/como-calcular-seu-peso-ideal.html
 * <p>
 * As formulas foram obtidas em sites de nutrição e saúde.
 */

public class CalcImc {

    DecimalFormat formato;

    public CalcImc() {
        formato = new DecimalFormat("#.##");
    }

    /**
     * Metodo que calcula o valor do IMC de uma pessoa
     *
     * @param peso   peso
     * @param altura altura
     * @return valor do imc
     */
    public double getImc(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Metodo que retona o status do IMC
     *
     * @param imc  valor do IMC
     * @param sexo masculino ou feminino
     * @return status do IMC
     */
    public String statusImc(double imc, String sexo) {
        if (sexo.equals("feminino")) {
            if (imc < 19.1) {
                return "Abaixo do peso";
            } else if (imc >= 19.1 && imc < 25.8) {
                return "No peso normal";
            } else if (imc >= 25.8 && imc < 27.3) {
                return "Sobrepeso";
            } else if (imc >= 27.3 && imc < 32.3) {
                return "Obesidade grau I";
            } else {
                return "Obesidade grau II";
            }
        } else if (sexo.equals("masculino")) {
            if (imc < 20.7) {
                return "Abaixo do peso";
            } else if (imc >= 20.7 && imc < 26.4) {
                return "Peso normal";
            } else if (imc >= 26.4 && imc < 27.8) {
                return "Sobrepeso";
            } else if (imc >= 27.8 && imc < 31.1) {
                return "Obesidade grau I";
            } else {
                return "Obesidade grau II";
            }
        } else {
            return null;
        }
    }


    /**
     * Metodo que retorna o peso ideal
     *
     * @param altura altura
     * @param imc    imc ideal
     * @return peso ideal
     */
    public double getPesoIdeal(double altura, double imc) {
        double pesoIdeal;
        pesoIdeal = ((altura * altura) * imc);
        pesoIdeal = Double.valueOf(formato.format(pesoIdeal));
        return pesoIdeal;
    }

    /**
     * Metodo que retorna o peso minimo ideal
     * O mínimo indica o menor peso que você pode ter sem caracterizar magreza ou desnutrição
     *
     * @param altura
     * @return peso minimo
     */
    public double getPesoIdealMinimo(double altura) {
        double pesoMinimo;
        pesoMinimo = (altura * altura) * 19.5;
        pesoMinimo = Double.valueOf(formato.format(pesoMinimo));
        return pesoMinimo;
    }

    /**
     * Metodo que retorna o peso maximo ideal
     * máximo indica o maior peso que você pode chegar sem caracterizar sobrepeso
     *
     * @param altura
     * @return peso minimo
     */
    public double getPesoIdealMaximo(double altura) {
        double pesoMaximo;
        pesoMaximo = (altura * altura) * 24.9;
        pesoMaximo = Double.valueOf(formato.format(pesoMaximo));
        return pesoMaximo;
    }

}

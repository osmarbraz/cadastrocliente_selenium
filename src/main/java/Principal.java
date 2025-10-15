import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Principal {

    public static void main(String[] args) {
        // Cria uma nova instância do driver do Chrome
        WebDriver driver = new ChromeDriver();
        // (1) Acessar uma página
        driver.get("https://osmarbraz.github.io/cadastrocliente_html");
        // (2) Localiza o elemento
        WebElement clienteId = driver.findElement(By.name("clienteId"));
        // (3-1) Digite algo para cadastrar
        clienteId.sendKeys("1");
        // (2) Localiza o elemento
        WebElement nome = driver.findElement(By.name("nome"));
        // (3-1) Digite algo para cadastrar
        nome.sendKeys("João da Silva");
        // (2) Localiza o elemento
        WebElement cpf = driver.findElement(By.name("CPF"));
        // (3-1) Digite algo para cadastrar
        cpf.sendKeys("123456789");
        // (2) Localiza o elemento        
        WebElement botao = driver.findElement(By.name("Cadastrar"));
        // (3-2) Agora envie o formulário. O WebDriver encontrará o formulário para nós a partir do elemento
        botao.click();
        // (3-3) Aguardar até 10 segundos por uma condição
        Wait<WebDriver> espera = new WebDriverWait(driver, Duration.ofSeconds(10));        
        espera.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        // (4) Verifique o conteúdo da página                
        WebElement corpoElementoTexto = driver.findElement(By.tagName("body"));
        String texto = corpoElementoTexto.getText();
        //System.out.println("Texto de retorno: " + texto);        
        //Verifica se o texto da página está correto         
        if (texto.contains("clienteId: 1\nNome: João da Silva\nCPF: 123456789")) {
            System.out.println("PASSOU");
        } else {
            System.out.println("FALHOU");
        }
        //Fecha o navegador
        driver.quit();
    }
}

#
# JFLAGS:  Define a variável para as flags do compilador JFLAGS
# JC: Define a variável 
# JVM: Define a variável para a Máquina Virtual Java (JVM)

JFLAGS = -classpath src/  
JC = javac
JVM = java

#
# Limpa qualquer alvos padrão para construir arquivos .class 
# a partir dos arquivos .java. Provemos nosso própria
# entrada alvo para este makefile.
#

.SUFFIXES: .java .class

#
# Alvo para nossa entrada criar nossos arquivos .class
# a partir dos arquivos .java
#

.java.class:
	$(JC) $(JFLAGS) $*.java 

#
# CLASSES é uma macro contendo os nomes dos arquivos .java
#

CLASSES = \
		src/projetoFinal/Main.java \
		src/projetoFinal/Jogo.java \
		src/projetoFinal/Frame.java \
		src/projetoFinal/PainelDeImagem.java \
		src/projetoFinal/Frame.java \
		src/projetoFinal/EventosMouse.java \
		src/projetoFinal/Pontuacao.java \
		src/projetoFinal/Imagem.java \
		src/projetoFinal/Label.java

#
# Entrada padrão para o make
#

#
# O primeiro main é para a criação dos arquivos .class
#
MAIN = src/projetoFinal/Main

#
# O segundo é a execução do arquivo.
#

MAIN2 = projetoFinal/Main

#
# A entrada padrão para o make é o alvo classes
#

default: classes

#
# Substituição de sufixo dentro de uma macro
#

classes: $(CLASSES:.java=.class)

#
# Alvo para execução do programa
#

run: $(MAIN).class
	$(JVM) $(JFLAGS) $(MAIN2)

#
# RM é uma macro pré-definida no make (RM = rm -f)
#

clean:
	$(RM) bin/projetoFinal/*.class

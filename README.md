# Hadron

A small (and slow) language for physics calculations.

## Install

Download the `hadron` file from the latest [Release](https://github.com/JoelCourtney/hadron/releases), and put it somewhere in your path.

## Build from Source

You must have [Java](https://www.java.com/en/) and a recent version of [Gradle](https://gradle.org/) installed.

Clone this repo in a permanent location, then build it. The `gradle` command may take a while.

```bash
git clone git@github.com:JoelCourtney/hadron.git
cd hadron
gradle hadron
```

Link the `hadron` executable to somewhere in your path, or add the repo to your path.

Lastly, create the `$HADRON_ROOT` environment variable, pointing to the `hadron` repo (NOT the `hadron` script). You can also put this in your shell rc file.

```bash
export HADRON_ROOT="/LOCATION/OF/hadron"
```

You can build the documentation to the `doc` directory with:

```bash
gradle dokka
```

## Usage

### Running a file

Write a hadron file (for example `example.hn`), and run it with:

```bash
hadron example.hn
```

You can also make a hadron executable file with a typical shabang:

```kotlin
#! /usr/bin/env hadron

println("Hello World!")
```

### REPL Mode

Just run `hadron` and type line-by-line:

```bash
$ hadron
Hadron v0.1-alpha REPL mode.
There is no help feature.
> "Hello World!"
Hello World!
> 
```

It currently does not support moving the cursor or using the up/down arrow keys to select previous lines.

## Syntax

See [this page](https://www.joelcourtney.net/hadron). Most of the features are not implemented yet; I'm adding them as I need them.

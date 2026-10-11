//1. Определить класс Прямая на плоскости (в пространстве),
// параметры которой задаются с помощью Рациональной Дроби.
// Определить точки пересечения прямой с осями координат.
// Определить координаты пересечения двух прямых.
// Создать массив/список/множество объектов и определить
// группы параллельных прямых.

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Type of lines (2 - in a plane, 3 - in space): ");
        int type = scan.nextInt();
        if (type == 2) {
            run2D(scan);
        } else if (type == 3) {
            run3D(scan);
        } else {
            System.err.print("Unknown type: " + type);
            System.exit(1);
        }
    }

    private static void run2D(Scanner scan) {
        List<Line2D> lines = new ArrayList<>();
        System.out.print("How many straight lines are there? ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Line " + (i + 1) + " (Ax + By + C = 0): \n");

            try {
                System.out.print("A (rational): ");
                Rational A = new Rational(scan.nextInt(), scan.nextInt());
                System.out.print("B (rational): ");
                Rational B = new Rational(scan.nextInt(), scan.nextInt());
                System.out.print("C (rational): ");
                Rational C = new Rational(scan.nextInt(), scan.nextInt());

                lines.add(new Line2D(A, B, C));
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid input. " + e.getMessage() + " Try again.\n");
                i--;
            }
        }


        List<List<Line2D>> groups = LineGroups.groupParallel2D(lines);

        System.out.print("Total number of groups of parallel lines: " + groups.size() + "\n");

        for (int i = 0; i < groups.size(); i++) {
            List<Line2D> g = groups.get(i);
            System.out.print("Group " + (i + 1) + " (" + g.size() + "): \n");
            for (Line2D line : g) {
                System.out.print(" " + line);
            }
        }
    }

    private static void run3D(Scanner scan) {
        List<Line3D> lines = new ArrayList<>();
        System.out.print("How many straight lines are there? ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Line " + (i + 1) + ": \n");
            System.out.print("Point (x, y, z): ");
            try{
            Rational px = new Rational(scan.nextInt(), scan.nextInt());
            Rational py = new Rational(scan.nextInt(), scan.nextInt());
            Rational pz = new Rational(scan.nextInt(), scan.nextInt());

            System.out.print("Direction vector (x, y, z): ");
            Rational vx = new Rational(scan.nextInt(), scan.nextInt());
            Rational vy = new Rational(scan.nextInt(), scan.nextInt());
            Rational vz = new Rational(scan.nextInt(), scan.nextInt());

            lines.add(new Line3D(new Point3D(px, py, pz),
                                 new Vector3D(vx, vy, vz)));
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid input. " + e.getMessage() + " Try again.");
                i--;
            }
        }

        List<List<Line3D>> groups = LineGroups.groupParallel3D(lines);

        System.out.print("Total number of groups of parallel lines: " + groups.size() + "\n");

        for (int i = 0; i < groups.size(); i++) {
            List<Line3D> g = groups.get(i);
            System.out.print("Group " + (i + 1) + " (" + g.size() + "): \n");
            for (Line3D line : g) {
                System.out.print(" " + line);
            }
        }
    }
}
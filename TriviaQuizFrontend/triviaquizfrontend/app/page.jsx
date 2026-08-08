import Link from "next/link";

export default function Home() {
    return (
        <div>
            <Link href="/questions">
                Get Questions
            </Link>
        </div>
    );
}